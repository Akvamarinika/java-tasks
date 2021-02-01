public enum Colors {
    BLACK("черный"),
    WHITE("белый"),
    RED("красный"),
    GREEN("зеленый"),
    BLUE("синий"),
    CHERRY("вишневый"),
    ORANGE("оранжевый"),
    GREY("серый");

    private String rusName;
    Colors(String rusName){
        this.rusName = rusName;
    }

    Colors(){}

    public String getRusName(){
        return rusName;
    }

    public void setRusName(String rusName) {
        this.rusName = rusName;
    }
}
