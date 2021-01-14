public enum Breeds{
    BRITISH(){
        @Override
        String rusName(){
            return "Британская";
        }
    },
    BURMESE{
        @Override
        String rusName(){
            return "Бирманская";
        }
    },
    TURKISH(){
        @Override
        String rusName(){
            return "Турецкая";
        }
    },
    SIBERIAN{
        @Override
        String rusName() {
            return "Сибирская";
        }
    },
    REGDALL(){
        @Override
        String rusName() {
            return "Регдолл";
        }
    };

    abstract String rusName();

}
