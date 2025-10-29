import dev.langchain4j.model.output.structured.Description;
import okhttp3.Address;

import java.time.LocalDate;

/**
 * @author gary.tsai
 * @created 2025/10/23
 */
public class Person {

    @Description("first name of a person") // you can add an optional description to help an LLM have a better understanding
    String firstName;
    String lastName;
    LocalDate birthDate;
}
