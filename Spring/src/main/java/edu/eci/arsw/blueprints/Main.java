package edu.eci.arsw.blueprints;


import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws BlueprintPersistenceException, BlueprintNotFoundException {
        ApplicationContext a = new ClassPathXmlApplicationContext("Archivo.xml");
        BlueprintsServices b = a.getBean(BlueprintsServices.class);
        Point[] pts0 = new Point[]{new Point(20, 30), new Point(5, 14), new Point(12, 24), new Point(30, 40)};
        Blueprint bp0 = new Blueprint("Picasso", "Arte", pts0);
        b.addNewBlueprint(bp0);
        Point[] pts = new Point[]{new Point(0, 0), new Point(10, 10)};
        Blueprint bp = new Blueprint("DaVinci", "asdd", pts);
        b.addNewBlueprint(bp);
        System.out.println(b.getBlueprint("Picasso", "Arte").getPoints().size());
        System.out.println(b.getBlueprint("DaVinci", "asdd").getPoints().size());
    }
}