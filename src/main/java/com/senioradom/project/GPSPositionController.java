package com.senioradom.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GPSPositionController {

    private final GPSPositionManager gpsPositionManager;

    @Autowired
    public GPSPositionController(
            GPSPositionManager gpsPositionManager
    ) {
        this.gpsPositionManager = gpsPositionManager;
    }

    /**
     * REST API example
     */
    @GetMapping("/gps-positions")
    public List<GPSPosition> findAllGPSPositions() {
        return gpsPositionManager.findAll();
    }

    @GetMapping("/gps-insert-positions")
    public List<GPSPosition> insertGPSPositions(@RequestParam("ID") Long idPosition,@RequestParam("X") Long xPosition,@RequestParam("Y") Long yPosition) {
        return gpsPositionManager.createGPSPositions(idPosition,xPosition,yPosition);
    }

    @GetMapping("/gps-delete-positions")
    public List<GPSPosition> deleteGPSPositions(@RequestParam("ID") Long idPosition,@RequestParam("X") Long xPosition,@RequestParam("Y") Long yPosition) {
        return gpsPositionManager.removeGPSPositions(idPosition,xPosition,yPosition);
    }
    @GetMapping("/gps-calculate-distance")
    public Double calculateGPSDistance(@RequestParam("ID1") Long idPoint1,@RequestParam("ID2") Long idPoint2) {
        return gpsPositionManager.calculateGPSDistance(idPoint1, idPoint2);
    }
    @GetMapping("/gps-init")
    public List<GPSPosition> initGPSPositions() {
        return gpsPositionManager.initSPG();
    }
}
