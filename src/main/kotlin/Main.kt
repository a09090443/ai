package tw.zipe

import dev.langchain4j.model.openai.OpenAiChatModel
import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.CommandLineParser
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options
import org.apache.commons.cli.ParseException
import org.apache.commons.cli.help.HelpFormatter

/**
 * @author zipe1
 * @created 2025/10/21
 */
fun main(args: Array<String>) {


    val model = OpenAiChatModel.builder()
        .apiKey("YOUR_API_KEY")
        // more configuration parameters here ...
        .build()

    val response = model.chat("你好")
    println(response)
    // 定義命令行選項
    val options = Options()

    // 添加選項：-h 或 --help 顯示幫助信息
    options.addOption("h", "help", false, "顯示幫助信息")

    // 使用傳統的 Option 建構子來避免呼叫被標示為已棄用的 builder.build()
    // 添加選項：-n 或 --name 後跟名稱
    options.addOption(Option("n", "name", true, "指定名稱"))

    // 添加選項：-c 或 --count 後跟次數
    options.addOption(Option("c", "count", true, "指定迴圈次數（整數）"))

    // 創建解析器
    val parser: CommandLineParser = DefaultParser()

    try {
        // 解析命令行參數
        val cmd: CommandLine = parser.parse(options, args)

        // 檢查是否請求幫助
        if (cmd.hasOption("h")) {
            val formatter = HelpFormatter.builder().get()
            formatter.printHelp("ai [options]", null, options, null, false)
            return
        }

        // 獲取名稱，預設為 "Kotlin"
        val name = cmd.getOptionValue("n", "Kotlin")

        // 獲取次數，預設為 5（安全解析）
        val count = try {
            cmd.getOptionValue("c")?.toInt() ?: 5
        } catch (e: NumberFormatException) {
            println("count 必須是整數，使用預設值 5")
            5
        }

        // 輸出問候
        println("Hello, $name!")

        // 迴圈輸出
        for (i in 1..count) {
            println("i = $i")
        }

    } catch (e: ParseException) {
        println("解析命令行參數時出錯: ${e.message}")
        val formatter = HelpFormatter.builder().get()
        formatter.printHelp("ai [options]", null, options, null, false)
    }
}
