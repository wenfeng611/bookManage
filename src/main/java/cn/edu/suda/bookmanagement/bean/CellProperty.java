package cn.edu.suda.bookmanagement.bean;


public class CellProperty {
    private String headerName;
    private String entityName;

    public CellProperty() {
    }

    public CellProperty(String headerName, String entityName) {
        this.headerName = headerName;
        this.entityName = entityName;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
