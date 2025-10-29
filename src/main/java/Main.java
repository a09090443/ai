import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_5_MINI;

/**
 * @author gary.tsai
 * @created 2025/10/23
 */
public class Main {
    public static void main(String[] args) {

        ChatModel chatModel = OpenAiChatModel.builder()
                .apiKey("sk-proj-xxx")
                .modelName(GPT_5_MINI)
                .responseFormat("json_schema")
                .strictJsonSchema(false)
                .logRequests(true)
                .logResponses(true)
                .build();

        PersonExtractor personExtractor = AiServices.create(PersonExtractor.class, chatModel);

        String text = """
            In 1968, amidst the fading echoes of Independence Day,
            a child named John arrived under the calm evening sky.
            This newborn, bearing the surname Doe, marked the start of a new journey.
            He was welcomed into the world at 345 Whispering Pines Avenue
            a quaint street nestled in the heart of Springfield
            an abode that echoed with the gentle hum of suburban dreams and aspirations.
            """;

        Person person = personExtractor.extractPersonFrom(text);

        System.out.println(person);
    }
}
