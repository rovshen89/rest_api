package DataTest;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "DataForPost")
    public Object[][] dataForPost(){

//        Object[][] data = new Object[2][3];
//        data[0][0] = "Adam";
//        data[0][1] = "Sandler";
//        data[0][2] = 1;
//
//        data[1][0] = "Jackie";
//        data[1][1] = "Chan";
//        data[1][2] = 2;
//
//        return data;

        return new Object[][]{
                {"Abraham", "Lincoln", 12},
                {"Steve", "Jobs", 13},
        };
    }

    @org.testng.annotations.DataProvider(name = "DataForDelete")
    public Object[] dataForDelete(){
        return new Object[]{
                5,8,9,10
        };
    }

}
