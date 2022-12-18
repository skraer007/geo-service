import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.geo.GeoServiceImpl;

@DisplayName("Тест определения локации")
@ExtendWith(MockitoExtension.class)
public class GeoServiceImplTest {
    @Mock
    private GeoServiceImpl geoService;

    @Test
    void test_ip () {
       // Arguments.of()
    }
}
