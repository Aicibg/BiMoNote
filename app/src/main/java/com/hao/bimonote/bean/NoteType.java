package com.hao.bimonote.bean;

/**
 * Created by DongHao on 2016/10/30
 * Description:
 */

public class NoteType {
    private String typeName;
    private int typeImageId;

    public NoteType(String typeName, int typeImageId) {
        this.typeName = typeName;
        this.typeImageId = typeImageId;
    }

    public NoteType() {
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getTypeImageId() {
        return typeImageId;
    }

    public void setTypeImageId(int typeImageId) {
        this.typeImageId = typeImageId;
    }

    @Override
    public String toString() {
        return "NoteType{" +
                "typeName='" + typeName + '\'' +
                ", typeImageId='" + typeImageId + '\'' +
                '}';
    }
}
