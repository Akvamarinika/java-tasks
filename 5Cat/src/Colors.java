public enum Colors {
    BLACK("черный"),
    BLUE_POINT,
    BROWN("коричневый"),
    CINNAMON("светло-коричневый"),
    CREAM("кремовый"),
    FAWN("желтовато-коричневый"),
    GINGER("рыжий"),
    GREY("серый"),
    WHITE("белый");

    private String rusColor;

    Colors(String rusColor){
        this.rusColor = rusColor;
    }

    Colors(){ }

    @Override
    public String toString(){
        if(rusColor != null){
            return this.name() + " " + this.rusColor;
        } else {
            return this.name();
        }
    }

}
