/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class Color {
    private int colorId;
    private String name;
    private int totalColor;

    public Color() {
    }

    public Color(int colorId, String name, int totalColor) {
        this.colorId = colorId;
        this.name = name;
        this.totalColor = totalColor;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalColor() {
        return totalColor;
    }

    public void setTotalColor(int totalColor) {
        this.totalColor = totalColor;
    }
    
    
}
