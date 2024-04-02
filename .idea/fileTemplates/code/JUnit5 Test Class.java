import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
#parse("File Header.java")
class ${NAME} {

    private final ${CLASS_NAME} solution = new ${CLASS_NAME}();
  ${BODY}
    public static Stream<Arguments> parameterSource() {
      return Stream.of(
          arguments()
      );
    }
}