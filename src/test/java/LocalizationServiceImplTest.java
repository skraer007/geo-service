import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

@DisplayName("Тест возщаемого текста")
public class LocalizationServiceImplTest {
    private LocalizationServiceImpl localizationService;


    @BeforeEach
    void set_up() {
        localizationService = new LocalizationServiceImpl();
    }

    @Test
    @DisplayName("Проверка приветсвия")
    void test_greetings() {
        Assertions.assertEquals("Добро пожаловать", localizationService.locale(Country.RUSSIA));
        Assertions.assertEquals("Welcome", localizationService.locale(Country.USA));
        Assertions.assertEquals("Welcome", localizationService.locale(Country.BRAZIL));
        Assertions.assertEquals("Welcome", localizationService.locale(Country.GERMANY));
    }
}