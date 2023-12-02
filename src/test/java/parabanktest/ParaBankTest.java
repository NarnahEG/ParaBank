package parabanktest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import parabank.ParaBank;

public class ParaBankTest {

    ParaBank para = new ParaBank();

    @BeforeTest
    public void loadPage() { para.loadPage();}

@Test
public void registration(){
    para.regRedirect();
    para.fillDetails();
    para.verifyText();
    }

    @AfterTest
    public  void verification(){
        para.verifyText();
        para.tearDown();
    }
}


