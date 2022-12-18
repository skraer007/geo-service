import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;

@DisplayName("Тест отправки сообщений")
public class MessageSenderImplTest {

    @Mock
    GeoServiceImpl geoServiceMock = Mockito.mock(GeoServiceImpl.class);

    @Mock
    LocalizationServiceImpl localizationServiceMock = Mockito.mock(LocalizationServiceImpl.class);

    @Test
    @DisplayName("Тестирование русского ip")
    void test_russianIp () {

        Mockito.when(localizationServiceMock.locale(Country.RUSSIA));
        Mockito.when(geoServiceMock.byIp("172."));
        MessageSenderImpl messageSender = new MessageSenderImpl(geoServiceMock, localizationServiceMock);
        Assertions.assertEquals(Country.RUSSIA , messageSender.send());
    }
}
