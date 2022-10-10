package Helpers;

public enum Grade {
    A("A"), 
    B("B"), 
    C("C"), 
    D("D"), 
    E("E"), 
    F("F");
    
    private String name;

    Grade(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public Boolean exists(String value){
        if(A.getName().equals(value) || B.getName().equals(value) ||C.getName().equals(value) ||
        D.getName().equals(value) || E.getName().equals(value) ||F.getName().equals(value)){
            return true;
        }
        return false;
    }
}