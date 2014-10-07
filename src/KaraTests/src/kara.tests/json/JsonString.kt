import kotlin.test.*
import kara.*
import org.apache.log4j.*
import org.junit.*

class JsonValidatorTest() {
    Before fun setUp() {
        BasicConfigurator.configure()
    }

    Test fun ensureNoTabsInJson1() {
        val inputStringWithTab = "��������� ���;?	��� ������ ����"
        val outputJsonWithoutTab = jsonString(inputStringWithTab)
        assertEquals("��������� ���;?    ��� ������ ����", outputJsonWithoutTab.value)
    }

    Test fun ensureNoTabsInJson2() {
        val inputStringWithTabs = "Actually these types of questions could be solved using different kinds of pre- and post release researches. We can offer the next options:\n-	Usability testing\n-	A/B testing"
        val outputJsonWithoutTab = jsonString(inputStringWithTabs)
        assertEquals("Actually these types of questions could be solved using different kinds of pre- and post release researches. We can offer the next options:\\n-    Usability testing\\n-    A/B testing", outputJsonWithoutTab.value)
    }


}