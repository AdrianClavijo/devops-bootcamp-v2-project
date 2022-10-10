package Helpers;

import javax.swing.text.StyledEditorKit.BoldAction;

public enum EducationLevel{
    
    ELEMENTARY_SCHOOL("ELEMENTARY SCHOOL"),
    MIDDLE_SCHOOL("MIDDLE SCHOOL"),
    HIGH_SCHOOL("HIGH SCHOOL");
    enum ELEMENTARYSCHOOL{
        MATHEMATICS("MATHEMATICS"), 
        SCIENCE("SCIENCE"), 
        LANGUAGE("LANGUAGE"), 
        ARTS("ARTS"), 
        MUSIC("MUSIC"), 
        READING("READING");
    
        private String name;
    
        ELEMENTARYSCHOOL( String name ){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public static Boolean exists(String value){
            if(MATHEMATICS.getName().equals(value) || SCIENCE.getName().equals(value) ||LANGUAGE.getName().equals(value) ||
            ARTS.getName().equals(value) ||MUSIC.getName().equals(value) ||READING.getName().equals(value)){
                return true;
            }
            return false;
        }
    }
    enum MIDDLESCHOOL{
        MATHEMATICS("MATHEMATICS"),  
        LITERATURE("LITERATURE"), 
        SCIENCE("SCIENCE"), 
        RELIGION("RELIGION"), 
        FOREIGN_LANGUAGE("FOREIGN_LANGUAGE");
        private String name;
    
        MIDDLESCHOOL( String name ){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public static Boolean exists(String value){
            if(MATHEMATICS.getName().equals(value) || LITERATURE.getName().equals(value) ||SCIENCE.getName().equals(value) ||
            RELIGION.getName().equals(value) ||FOREIGN_LANGUAGE.getName().equals(value)){
                return true;
            }
            return false;
        }
    }
        enum HIGHSCHOOL{
            MATHEMATICS("MATHEMATICS"),
            SCIENCE("SCIENCE"),
            GEOMETRY("GEOMETRY"),
            ALGEBRA("ALGEBRA"),
            BIOLOGY("BIOLOGY"),
            PHYSICS("PHYSICS"),
            CHEMESTRY("CHEMESTRY"),
            HISTORY("HISTORY"),
            ART("ART"),
            MUSIC("MUSIC"),
            PHYSICAL_EDUCATION("PHYSICAL_EDUCATION");
        
            private String name;
        
            HIGHSCHOOL( String name ){
                this.name = name;
            }
            public String getName(){
                return this.name;
            }
            public static Boolean exists(String value){
                if(MATHEMATICS.getName().equals(value) || SCIENCE.getName().equals(value) ||GEOMETRY.getName().equals(value) ||
                ALGEBRA.getName().equals(value) ||BIOLOGY.getName().equals(value) ||PHYSICS.getName().equals(value) ||
                CHEMESTRY.getName().equals(value) ||HISTORY.getName().equals(value) ||ART.getName().equals(value) ||
                MUSIC.getName().equals(value) ||PHYSICAL_EDUCATION.getName().equals(value)){
                    return true;
                }
                return false;
            }
        }

    private String name;

        EducationLevel( String name ){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public Boolean exists(String value){
            if(ELEMENTARY_SCHOOL.getName().equals(value) || MIDDLE_SCHOOL.getName().equals(value) ||HIGH_SCHOOL.getName().equals(value)){
                return true;
            }
            return false;
        }
        public Boolean existsAll(String value){
            if(ELEMENTARYSCHOOL.exists(value) ||
            MIDDLESCHOOL.exists(value) ||
            HIGHSCHOOL.exists(value) ){
                return true;
            }
            return false;            
        }
        public void ESchoolSubjects(){
            for(ELEMENTARYSCHOOL ES : ELEMENTARYSCHOOL.values()){
                System.out.println("  - "+ES.getName());
            }         
        }
        public void MSchoolSubjects(){
            for(MIDDLESCHOOL MS : MIDDLESCHOOL.values()){
                System.out.println("  - "+MS.getName());
            }         
        }
        public void HSchoolSubjects(){
            for(HIGHSCHOOL HS : HIGHSCHOOL.values()){
                System.out.println("  - "+HS.getName());
            }         
        }
}