import dev.langchain4j.model.output.structured.Description;

/**
 * @author gary.tsai
 * @created 2025/10/23
 */
@Description("an address") // you can add an optional description to help an LLM have a better understanding
class Address {
    String street;
    Integer streetNumber;
    String city;
}
