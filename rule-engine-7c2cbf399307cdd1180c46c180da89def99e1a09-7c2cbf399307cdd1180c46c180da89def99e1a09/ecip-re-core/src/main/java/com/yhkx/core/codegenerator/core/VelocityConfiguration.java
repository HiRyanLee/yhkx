package com.yhkx.core.codegenerator.core;

/**
 * velocity的配置
 *
 * @author LiSs
 * @date on 2018/7/04
 */
public class VelocityConfiguration {

    private String targetDir;

    private String modelPackage;

    private String xmlPackage;

    private String mapperPackage;

    private String examplePackage;

    private String restControllerPackage;

    private String controllerPackage;

    public String getRestControllerPackage() {
        return restControllerPackage;
    }

    public void setRestControllerPackage(String restControllerPackage) {
        this.restControllerPackage = restControllerPackage;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    public String getModelPackage() {
        return modelPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getExamplePackage() {
        return examplePackage;
    }

    public void setExamplePackage(String examplePackage) {
        this.examplePackage = examplePackage;
    }

    public String getTargetDir() {
        return targetDir;
    }

    public void setTargetDir(String targetDir) {
        this.targetDir = targetDir;
    }

    public String getXmlPackage() {
        return xmlPackage;
    }

    public void setXmlPackage(String xmlPackage) {
        this.xmlPackage = xmlPackage;
    }

}
