import dev.langchain4j.service.UserMessage;

/**
 * @author gary.tsai
 * @created 2025/10/23
 */
public interface PersonExtractor {
    @UserMessage("Extract information about a person from {{it}}")
    Person extractPersonFrom(String text);
}
