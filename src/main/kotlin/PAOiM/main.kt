package PAOiM

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.swing.Swing
import PAOiM.Providers.PostProvider
import PAOiM.Utils.Parser
import java.awt.Dimension
import javax.swing.*
import javax.swing.table.DefaultTableModel

fun main() {
    GlobalScope.launch(Dispatchers.Swing) {
        val postProvider = PostProvider();
        val frame = JFrame().apply {
            title = "display API"
            size = Dimension(900, 600)
            setLocationRelativeTo(null)
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            layout = BoxLayout(contentPane, BoxLayout.Y_AXIS)
        }

        val button = JButton("Get data")
        val label = JLabel("This is a label")
        val columnNames = arrayOf(
            "userId",
            "id",
            "title",
            "body",
        )
        val model = DefaultTableModel(columnNames, 0)
        val table = JTable(model)

        button.addActionListener {
            postProvider.sendGet();
            val parser = Parser();
            val resp = parser.parse(postProvider.sendGet());
            if (resp != null) {
                model.dataVector.removeAllElements();
                for(post in resp) {
                    val data = arrayOf<Any>(
                        post.userId, post.id, post.title, post.body
                    )
                    model.addRow(data)
                }
            }
            label.text = "Updated posts"
        }

        frame.add(label)
        frame.add(button)
        frame.add(table)
        frame.isVisible = true
    }
}