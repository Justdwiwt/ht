package cn.tedu.ht.pojo;

public class Module extends BaseEntity {

    private String moduleId;
    private String name;
    private int ctype;
    private int state;
    private int orderNo;
    private String remark;

    private Module parentModule;
    private String id;
    private String pId;
    private boolean checked;

    public String getId() {
        return moduleId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return parentModule == null ? "0" : parentModule.moduleId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCtype() {
        return ctype;
    }

    public void setCtype(int ctype) {
        this.ctype = ctype;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public Module getParentModule() {
        return parentModule;
    }

    public void setParentModule(Module parentModule) {
        this.parentModule = parentModule;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleId='" + moduleId + '\'' +
                ", name='" + name + '\'' +
                ", ctype=" + ctype +
                ", state=" + state +
                ", orderNo=" + orderNo +
                ", remark='" + remark + '\'' +
                ", parentModule=" + parentModule +
                ", id='" + id + '\'' +
                ", pId='" + pId + '\'' +
                ", checked=" + checked +
                '}';
    }

}
