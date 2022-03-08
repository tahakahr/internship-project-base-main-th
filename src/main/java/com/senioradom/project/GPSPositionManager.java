package com.senioradom.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GPSPositionManager {

    private final GPSPositionRepository gpsPositionRepository;

    @Autowired
    public GPSPositionManager(
            final GPSPositionRepository gpsPositionRepository
    ) {
        this.gpsPositionRepository = gpsPositionRepository;
        //initSPG();
    }

    /**
     * TODO Modify to retrieve GPSPosition from database
     */
    public List<GPSPosition> findAll() {
     //   return List.of(GPSPosition.builder().id(1L).build(), GPSPosition.builder().id(2L).build());
        return gpsPositionRepository.findAll();
    }

    public List<GPSPosition> createGPSPositions(Long idPosition, Long xPosition, Long yPosition) {
        GPSPosition gpsPosition = GPSPosition.builder().id(idPosition).latitude(xPosition).longitude(yPosition).build();
        gpsPositionRepository.save(gpsPosition);
        return findAll();
    }

    public List<GPSPosition> removeGPSPositions(Long idPosition, Long xPosition, Long yPosition) {
        GPSPosition gpsPosition = GPSPosition.builder().id(idPosition).latitude(xPosition).longitude(yPosition).build();
        gpsPositionRepository.delete(gpsPosition);
        return findAll();
    }

    public Double calculateGPSDistance(Long idPoint1, Long idPoint2) {
        GPSPosition point1 = gpsPositionRepository.getById(idPoint1);
        GPSPosition point2 = gpsPositionRepository.getById(idPoint2);

        Double distance = Math.sqrt(
                Math.pow(point1.getLatitude()-point2.getLatitude(), 2)
                + Math.pow(point1.getLongitude()-point2.getLongitude(), 2)
        );

        return distance;
    }

    public List<GPSPosition> initSPG() {
        createGPSPositions(1L, 1L, 0L);
        createGPSPositions(2L, 4L, 0L);
        createGPSPositions(3L, 2L, 3L);
        createGPSPositions(4L, 4L, 8L);
        createGPSPositions(5L, 7L, 1L);
        createGPSPositions(6L, 96L, 10L);
        createGPSPositions(7L, 152L, 360L);
        createGPSPositions(8L, 420L, 1052L);
        createGPSPositions(9L, 15340L, 15413L);
        return createGPSPositions(10L, 4520L, 1895L);
    }
}
