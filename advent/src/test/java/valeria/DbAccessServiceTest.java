package valeria;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringRunner.class)
public class DbAccessServiceTest {

    @Autowired
    private DbAccessService dbAccessService;

    //@Container
    //private static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:latest");

    //@BeforeAll
    //public static void setup(){
    //    postgreSQLContainer.start();
    //}

    //@DynamicPropertySource
    //public static void overrideProperties(DynamicPropertyRegistry registry){
    //    registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
    //    registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
    //    registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
    //}


    @Test
    public void whenPostDayActivity_thenReturnDayCorrectly(){
        dbAccessService.postDayActivity(29, "decorate the Christmas tree");
        dbAccessService.postDayActivity(22, "bake cookies");

        Day day22 = dbAccessService.getDay(22);
        Day day29 = dbAccessService.getDay(29);
        assertEquals(day22.getActivity(), "bake cookies");
        assertEquals(day29.getActivity(), "decorate the Christmas tree");
    }
}
