package generater;

import br.com.luque.java2uml.plantuml.PlantUML;

public class UMLGenerator {
    public static void main(String[] args) {
        PlantUML plantUML = new PlantUML();
        plantUML.addPackages("com.example"); // 你的包名
        plantUML.ignorePackages("com.example.myapp.utils"); // 排除不需要的包

        String diagramText = plantUML.generateClassDiagram();
        System.out.println(diagramText); // 输出 PlantUML 描述
    }
}
