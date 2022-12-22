import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

@DisplayName("Тест определения локации")
@ExtendWith(MockitoExtension.class)
public class GeoServiceImplTest {

    private GeoServiceImpl geoService;
    private Location location1;
    private Location location2;
    private Location location3;
    private Location location4;

    @BeforeEach
    void set_up() {
        geoService = new GeoServiceImpl();
        location1 = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        location2 = new Location("New York", Country.USA, " 10th Avenue", 32);
        location3 = new Location("Moscow", Country.RUSSIA, null, 0);
        location4 = new Location("New York", Country.USA, null, 0);
    }

    @Test
    @DisplayName("Проверка определния локации по ip")
    void test_ip() {
        Assertions.assertEquals(location1.getBuiling(), geoService.byIp("172.0.32.11").getBuiling());
        Assertions.assertEquals(location2.getStreet(), geoService.byIp("96.44.183.149").getStreet());
        Assertions.assertEquals(location3.getCity(), geoService.byIp("172.").getCity());
        Assertions.assertEquals(location4.getCity(), geoService.byIp("96.").getCity());
    }
}