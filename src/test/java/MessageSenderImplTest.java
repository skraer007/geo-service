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
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.Map;

@DisplayName("Тест отправки сообщений")
@ExtendWith(MockitoExtension.class)
public class MessageSenderImplTest {

    @Mock
    private GeoServiceImpl geoServiceMock;

    @Mock
    private LocalizationServiceImpl localizationServiceMock;

    private MessageSenderImpl messageSender;

    @BeforeEach
    void setUp() {
        messageSender = new MessageSenderImpl(geoServiceMock, localizationServiceMock);
    }

    @Test
    @DisplayName("Тестирование русского ip")
    void test_russianIp() {
        Assertions.assertEquals("Добро пожаловать", actualResult("172.", Country.RUSSIA));
    }

    @Test
    @DisplayName("Тестирование американского ip")
    void test_USAIp() {
        Assertions.assertEquals("Welcome", actualResult("96.", Country.USA));
    }

    @Test
    @DisplayName("Тестирование Московского ip")
    void test_MoscowIp() {
        Assertions.assertEquals("Добро пожаловать", actualResult("172.0.32.11", Country.RUSSIA));
    }

    @Test
    @DisplayName("Тестирование ip Нью-йорка")
    void test_NewYorkIp() {
        Assertions.assertEquals("Welcome", actualResult("96.44.183.149", Country.USA));
    }

    private String actualResult(String ipAddress, Country country) {
        Location location;
        String greetings;
        if (country == Country.RUSSIA) {
            greetings = "Добро пожаловать";
            location = new Location("Moscow", country, null, 0);
        } else {
            greetings = "Welcome";
            location = new Location("New York", country, null, 0);
        }
        Mockito.when(geoServiceMock.byIp(Mockito.startsWith(ipAddress)))
                .thenReturn(location);
        Mockito.when(localizationServiceMock.locale(country))
                .thenReturn(greetings);
        return messageSender.send(Map.of(MessageSenderImpl.IP_ADDRESS_HEADER, ipAddress));
    }
}