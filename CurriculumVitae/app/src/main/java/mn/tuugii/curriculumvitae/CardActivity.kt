package mn.tuugii.curriculumvitae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_card_view.*
import mn.tuugii.curriculumvitae.classes.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.content_main.*
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class CardActivity : AppCompatActivity() {
    val dformat: SimpleDateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)
    var personList = ArrayList<Person>()
    var adapter : RecyclerView.Adapter<CardViewAdapter.MyViewHolder>? = null

    var undoOnClickListener: View.OnClickListener = View.OnClickListener { view ->

        personList.removeAt(personList.size - 1)
        adapter?.notifyDataSetChanged()

        Snackbar.make(view, "Person removed", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view)

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            addListItem()
            Snackbar.make(view, "New person added to list", Snackbar.LENGTH_LONG)
                .setAction("Undo", undoOnClickListener).show()
        }

        init()
        loadDataFromStorage()

        rv?.layoutManager = LinearLayoutManager(this)
        adapter = CardViewAdapter(this, personList)
        rv!!.adapter = adapter
    }
    private fun addListItem() {
        addPerson()
        adapter?.notifyDataSetChanged()
    }

    fun init(){

        //Puujee
        var a1 = Address(11,"FairField", "IOWA", "", 52556, "Trlr-4A", "")

        var addList1 = ArrayList<Address>()
        addList1.add(a1)

        var e1 = Education(21, dformat.parse("09/01/2000"), dformat.parse("06/01/2004"),
            "National Univercity of Mongolia", 3.4, "Bachelor", "")
        var eduList1 = ArrayList<Education>()
        eduList1.add(e1)

        var w11 = Work(31, "Zoosbank", dformat.parse("06/20/2005"), dformat.parse("11/29/2009"),
            "Software engineer", "in It department")

        var workList1 = ArrayList<Work>()
        workList1.add(w11)

        var pr11 = Project(41, "Internet banking", dformat.parse("06/20/2005"), dformat.parse("11/29/2009"),
            "php, javascript, html", "")

        var prList1 = ArrayList<Project>()
        prList1.add(pr11)

        var p1 = Person(1, "Purevdemberel", "Byambatogtokh", "", "Software Developer",
            dformat.parse("09/03/1989"),R.drawable.puje,
            "999-999-9999",
            "purevdemberel@gmail.com",
            "bpurevdemberel",
            "@bpurevdemberel",
            "I have 5 years experiences on the Java, J2EE and other software. In this term, developed and used applications are: Java, JSP, HTML5, CSS3, jQuery, JavaScript, JSON, MySQL Servlet, Hibernate. Object Oriented (OOPS) programming skill is usually used for development of Java and applications. Further, I will work on theproject development of software by a result from more study on configuration, integration and implementation. ",
            "Developed new authorization mode for social and smart banking using biometric security. Created streamlined online customer registration system, measurably increasing customer sign-ups\n",
            "https://medium.com/@puje_b",
            "Mongolian University of Science & Technology – / Ulaanbaatar, Mongolia / 2011 / Bachelor / Software Engineering",
            "I’ve always preferred to work in groups and find that my collaborative nature is one of my strongest attributes. On projects that I directed, I work well to inspire diverse team members and work side by side with them to achieve the project goals. In fact, I’ve increased productivity by ten percent over the course of two years. ",
            " - Creativity\n" +
                    " - Versatility\n" +
                    " - Flexibility\n" +
                    " - Focused\n" +
                    " - Taking Intiative\n",
            " - Self-criticism\n" +
                    " - Insecure\n" +
                    " - Too detail oriented\n" +
                    " - Presentation skills\n",
            "Languages:  Java, SQL\n" +
                    "Web:  HTML5, CSS3, JavaScript, jQuery, Thymeleaf, AJAX, JSON, Bootstrap\n" +
                    "Web Services:  RESTful, Microservices\n" +
                    "Web/App Servers:  Apache Tomcat, Nginx\n" +
                    "Frameworks:  Spring (Core, Boot, Security, Cloud), Hibernate, Protractor\n" +
                    "Databases:  MySQL, MongoDB, Cassandra\n" +
                    "Design Patterns:  Singleton, Prototype, Factory\n" +
                    "SDLC:  Agile-Scrum\n" +
                    "Tools:  Spring Tool Suite, IntelliJ IDEA, Visual Studio Code, JUnit, Mockito, Git, Postman, Maven\n" +
                    "Platforms:  Windows, Linux, Mac\n",
            "1. COMPANY NAME: Bodi Electronics LLC\n" +
                    "CITY/STATE: Ulaanbaatar, Mongolia\n" +
                    "DATES EMPLOYED: 2011 - present\n" +
                    "COMPANY INFORMATION:\n" +
                    "JOB TITLE: System Administrator \n" +
                    "JOB DESCRIPTION: Oversaw large-scale software reliability and system availability. Co-managed ERP implementation and migration project. Created IT compliance policy on servers and computer systems.\n\n",
            "1. PROJECT TITLE: CarPool Application\n" +
                    "SCHOOL: MUM\n" +
                    "PROJECT YEAR: 2019\n" +
                    "PROJECT DESCRIPTION: I designed and developed this application with 5 members. Users can add product to the system and other users can make a comment about this product and deployment\n" +
                    "TECHNOLOGIES USED (in order):\n" +
                    "Spring BOOT, Angular, MicroServices, Google Cloud Kubernetes, Zipkin, , MongoDB, Cassandra, JSON, JavaScript, HTML, CSS, Git, IntelliJ\n\n\n" +
                    "2. PROJECT TITLE: CarRental Application\n" +
                    "SCHOOL: MUM\n" +
                    "PROJECT YEAR: 2019\n" +
                    "PROJECT DESCRIPTION: I designed and developed this application with 2 members. This application has the following operations:\n" +
                    "-\tUser and car registration, User can join another team\n" +
                    "-\tTask and comment registration, \n" +
                    "-\tOverdue tasks to highlighted to users, …\n" +
                    "TECHNOLOGIES USED (in order):\n" +
                    "JAVA, Spring, servlets, JSON, AJAX, JQuery, HTML, CSS, IntelliJ, Maven, Postgre\n\n\n" +
                    "3. PROJECT TITLE: Rent of Trailer Utopia android App\n" +
                    "SCHOOL: MUM\n" +
                    "PROJECT YEAR: 2019\n" +
                    "PROJECT DESCRIPTION: Worked with three members to design and develop a android Rent of Trailer Utopia park android application. It contains user, trailer, administrator and rent registration and rent checkout…\n",


            addList1,
            eduList1,
            workList1,
            prList1
            )
        personList.add(p1)


        //Tuugii
        var a2 = Address(12, "FairField", "IOWA", "", 52556, "Trlr-4A", "")

        var addList2 = ArrayList<Address>()
        addList2.add(a2)

        var e2 = Education(22, dformat.parse("09/01/2000"), dformat.parse("06/01/2004"),
            "National Univercity of Mongolia", 3.4, "Bachelor", "")
        var eduList2 = ArrayList<Education>()
        eduList2.add(e2)

        var w1 = Work(31, "Zoosbank", dformat.parse("06/20/2005"), dformat.parse("11/29/2009"),
            "Software engineer", "in It deaprtment")
        var w2 = Work(32, "Statebank", dformat.parse("11/29/2009"), dformat.parse("06/20/2011"),
            "Senior developer", "in It deaprtment")
        var w3 = Work(32, "Infosoft", dformat.parse("06/20/2011"), dformat.parse("11/28/2018"),
            "Senior developer", "in It deaprtment")

        var workList2 = ArrayList<Work>()
        workList2.add(w1)
        workList2.add(w2)
        workList2.add(w3)

        var pr1 = Project(41, "Internet banking", dformat.parse("06/20/2005"), dformat.parse("11/29/2009"),
            "php, javascript, html", "")

        var prList2 = ArrayList<Project>()
        prList2.add(pr1)
        var p2 = Person(2, "Battuguldur", "Ganbold", "Tuugii", "Software Developer",
            dformat.parse("12/20/1983"), R.drawable.tuugii,
            "650-745-6863",
            "tuugii83@gmail.com",
            "gtuugii",
            "gtuugii",
            "I have 10 years experiences on the Java, J2EE and other software. In this term, developed and used applications are: Java, JSP, HTML5, CSS3, jQuery, JavaScript, JSON, MySQL Servlet, Hibernate. Object Oriented (OOPS) programming skill is usually used for development of Java and applications. Further, I will work on theproject development of software by a result from more study on configuration, integration and implementation. ",
            "Developed new authorization mode for social and smart banking using biometric security. Created streamlined online customer registration system, measurably increasing customer sign-ups\n",
            "https://medium.com/@tuugii_g",
            " - National University of Mongolia / Ulaanbaatar, Mongolia / 2004 / Bachelor / 3.5 / Software Engineering\n" +
                    " - National University of Mongolia / Ulaanbaatar, Mongolia / 2018 / Master / 3.8 / Software Engineering",
            "My greatest strength is my writing skills. I work well under pressure, and I've never missed a deadline. One specific example that comes to mind is when I was asked to complete a project that a fellow colleague forgot about. My editor didn’t realize this until two hours before the deadline. It was an important piece, so I got to work, and with feverish precision, I was able to complete the article. Not only was it finished on time, but it was received very well by readers of the publication.",
            " - Creativity\n" +
                    " - Versatility\n" +
                    " - Flexibility\n" +
                    " - Focused\n" +
                    " - Taking Intiative\n",
            " - Self-criticism\n" +
                    " - Insecure\n" +
                    " - Too detail oriented\n" +
                    " - Presentation skills\n",
            "Languages: C#, C/C++, PHP, Java, JavaScript, Delphi\n" +
                    "Web: HTML, CSS, AJAX, XML, JSON, JavaScript, jQuery, Bootstrap, Servlet, JSP\n" +
                    "Web Services: RESTful, Microservices\n" +
                    "Web and Application Servers: Apache, Tomcat, IIS, GlassFish\n" +
                    "Frameworks: .Net, Spring, Node.js, Express, Angular\n" +
                    "Databases:  Oracle, MSSQL, MySQL, MS Access, MongoDB\n" +
                    "Design Patterns: Singleton, Factory, Iterator, Template, State\n" +
                    "SDLC: Waterfall, Agile\n" +
                    "Tools:  MS Visual Studio, Visual Source Safe, GitHub, IntelliJ IDEA, Eclipse, NetBeans, Oracle SQL Developer, Toad for Oracle and MySQL, MySQL Workbench\n" +
                    "Platforms: Windows, Mac\n" +
                    "\n",
            "1. COMPANY NAME: Infosoft LLC\n" +
                    "CITY/STATE: Ulaanbaatar, Mongolia\n" +
                    "DATES EMPLOYED: 2011 - present\n" +
                    "COMPANY INFORMATION: Software vendor for Insurance system\n" +
                    "JOB TITLE: Co-founder\n" +
                    "JOB DESCRIPTION: \n" +
                    "I led team of up to 10 employees in creating, developing and implementing insurance core system. \n\n" +
                    "2. COMPANY NAME: State bank LLC\n" +
                    "CITY/STATE: Ulaanbaatar, Mongolia\n" +
                    "DATES EMPLOYED: 2009-2011\n" +
                    "COMPANY INFORMATION: State bank is a commercial bank owned by Mongolian government. It has over 500 branches nationwide and 3500 employees\n" +
                    "JOB TITLE: Senior Software Engineer\n" +
                    "JOB DESCRIPTION: Manage subordinates 2-3-person and run bank wide IT projects. Support system maintenance. Administer bank systems\n\n" +
                    "3. COMPANY NAME: Zoos bank LLC\n" +
                    "CITY/STATE: Ulaanbaatar, Mongolia\n" +
                    "DATES EMPLOYED: 2005 – 2009\n" +
                    "COMPANY INFORMATION: Zoos bank was a retail bank in Mongolia. Established in 1999 and taken over by government and reestablished as State bank because of financial difficulties.\n" +
                    "JOB TITLE: Developer\n" +
                    "JOB DESCRIPTION: Software developer in IT department. I created and developed different softwares in PHP, Delphi and maintained banking system parameter, database administration and system administration.\n",
            "1. PROJECT TITLE: Product Review Application\n" +
                    "SCHOOL: MUM\n" +
                    "PROJECT YEAR:2019\n" +
                    "PROJECT DESCRIPTION: I designed and developed this application with 2 members. Users can add product to the system and other users can make a comment about this product \n" +
                    "TECHNOLOGIES USED (in order):\n" +
                    "NodeJS, Express, Restful Web Service, MongoDB, Angular, JSON, JavaScript, HTML, CSS, Git, IntelliJ\n\n" +
                    "2. PROJECT TITLE:Task List Application\n" +
                    "SCHOOL:MUM\n" +
                    "PROJECT YEAR:2019\n" +
                    "PROJECT DESCRIPTION: I designed and developed this application with 2 members. This application has the following operations:\n" +
                    "-\tUser and team registeration, User can join another team\n" +
                    "-\tTask and comment registeration, \n" +
                    "-\tOverdue tasks to highlighted to users, …\n" +
                    "TECHNOLOGIES USED (in order): \n" +
                    "JAVA, Spring, servlets, JSON, AJAX, JQuery, HTML, CSS, IntelliJ, Maven, Postgre\n\n" +
                    "3. PROJECT TITLE:Library System\n" +
                    "SCHOOL: MUM\n" +
                    "PROJECT YEAR:2018\n" +
                    "PROJECT DESCRIPTION: Worked with three members to design and develop a small library system. It contains librarian, author, administrator and book registeration and book checkout… \n" +
                    "TECHNOLOGIES USED (in order):\n" +
                    "Java, CSS, Gitlab, Singleton, JavaFx UI",
            addList2,
            eduList2,
            workList2,
            prList2)

        personList.add(p2)
    }

    fun addPerson(){
        //New Person
        var a2 = Address(12, "FairField", "IOWA", "", 52556, "Trlr-4A", "")

        var addList2 = ArrayList<Address>()
        addList2.add(a2)

        var e2 = Education(22, dformat.parse("09/01/2000"), dformat.parse("06/01/2004"),
            "National Univercity of Mongolia", 3.4, "Bachelor", "")
        var eduList2 = ArrayList<Education>()
        eduList2.add(e2)

        var w1 = Work(31, "Zoosbank", dformat.parse("06/20/2005"), dformat.parse("11/29/2009"),
            "Software engineer", "in It deaprtment")
        var w2 = Work(32, "Statebank", dformat.parse("11/29/2009"), dformat.parse("06/20/2011"),
            "Senior developer", "in It deaprtment")
        var w3 = Work(32, "Infosoft", dformat.parse("06/20/2011"), dformat.parse("11/28/2018"),
            "Senior developer", "in It deaprtment")

        var workList2 = ArrayList<Work>()
        workList2.add(w1)
        workList2.add(w2)
        workList2.add(w3)

        var pr1 = Project(41, "Internet banking", dformat.parse("06/20/2005"), dformat.parse("11/29/2009"),
            "php, javascript, html", "")

        var prList2 = ArrayList<Project>()
        prList2.add(pr1)
        var p2 = Person(2, "Renuka", "Mohanraj", "Renuka", "Associate Professor of Computer Science",
            dformat.parse("12/20/1983"), R.drawable.renuka,
            "641-472-7000, ext. 4332",
            "rMohanraj@mum.edu",
            "RenukaMohanraj",
            "RenukaMohanraj",
            "I have 20 years experiences on the Java, J2EE and other software. In this term, developed and used applications are: Java, JSP, HTML5, CSS3, jQuery, JavaScript, JSON, MySQL Servlet, Hibernate. Object Oriented (OOPS) programming skill is usually used for development of Java and applications. Further, I will work on theproject development of software by a result from more study on configuration, integration and implementation. ",
            "•Developed new authorization mode for social and smart banking using biometric security. Created streamlined online customer registration system, measurably increasing customer sign-ups\n",
            "https://medium.com/@renuka_m",
            "Educational Background",
            "My greatest strength is my writing skills. I work well under pressure, and I've never missed a deadline. One specific example that comes to mind is when I was asked to complete a project that a fellow colleague forgot about. My editor didn’t realize this until two hours before the deadline. It was an important piece, so I got to work, and with feverish precision, I was able to complete the article. Not only was it finished on time, but it was received very well by readers of the publication.",
            " - Creativity\n" +
                    " - Versatility\n" +
                    " - Flexibility\n" +
                    " - Focused\n" +
                    " - Taking Intiative\n",
            " - Self-criticism\n" +
                    " - Insecure\n" +
                    " - Too detail oriented\n" +
                    " - Presentation skills\n",
            "Languages: C#, C/C++, PHP, Java, JavaScript, Delphi\n" +
                    "Web: HTML, CSS, AJAX, XML, JSON, JavaScript, jQuery, Bootstrap, Servlet, JSP\n" +
                    "Web Services: RESTful, Microservices\n" +
                    "Web and Application Servers: Apache, Tomcat, IIS, GlassFish\n" +
                    "Frameworks: .Net, Spring, Node.js, Express, Angular\n" +
                    "Databases:  Oracle, MSSQL, MySQL, MS Access, MongoDB\n" +
                    "Design Patterns: Singleton, Factory, Iterator, Template, State\n" +
                    "SDLC: Waterfall, Agile\n" +
                    "Tools:  MS Visual Studio, Visual Source Safe, GitHub, IntelliJ IDEA, Eclipse, NetBeans, Oracle SQL Developer, Toad for Oracle and MySQL, MySQL Workbench\n" +
                    "Platforms: Windows, Mac\n" +
                    "\n",
            "1. COMPANY NAME: Infosoft LLC\n" +
                    "CITY/STATE: Ulaanbaatar, Mongolia\n" +
                    "DATES EMPLOYED: 2011 - present\n" +
                    "COMPANY INFORMATION: Software vendor for Insurance system\n" +
                    "JOB TITLE: Co-founder\n" +
                    "JOB DESCRIPTION: \n" +
                    "I led team of up to 10 employees in creating, developing and implementing insurance core system. \n\n" +
                    "2. COMPANY NAME: State bank LLC\n" +
                    "CITY/STATE: Ulaanbaatar, Mongolia\n" +
                    "DATES EMPLOYED: 2009-2011\n" +
                    "COMPANY INFORMATION: State bank is a commercial bank owned by Mongolian government. It has over 500 branches nationwide and 3500 employees\n" +
                    "JOB TITLE: Senior Software Engineer\n" +
                    "JOB DESCRIPTION: Manage subordinates 2-3-person and run bank wide IT projects. Support system maintenance. Administer bank systems\n\n" +
                    "3. COMPANY NAME: Zoos bank LLC\n" +
                    "CITY/STATE: Ulaanbaatar, Mongolia\n" +
                    "DATES EMPLOYED: 2005 – 2009\n" +
                    "COMPANY INFORMATION: Zoos bank was a retail bank in Mongolia. Established in 1999 and taken over by government and reestablished as State bank because of financial difficulties.\n" +
                    "JOB TITLE: Developer\n" +
                    "JOB DESCRIPTION: Software developer in IT department. I created and developed different softwares in PHP, Delphi and maintained banking system parameter, database administration and system administration.\n",
            "1. PROJECT TITLE: Product Review Application\n" +
                    "SCHOOL: MUM\n" +
                    "PROJECT YEAR:2019\n" +
                    "PROJECT DESCRIPTION: I designed and developed this application with 2 members. Users can add product to the system and other users can make a comment about this product \n" +
                    "TECHNOLOGIES USED (in order):\n" +
                    "NodeJS, Express, Restful Web Service, MongoDB, Angular, JSON, JavaScript, HTML, CSS, Git, IntelliJ\n\n" +
                    "2. PROJECT TITLE:Task List Application\n" +
                    "SCHOOL:MUM\n" +
                    "PROJECT YEAR:2019\n" +
                    "PROJECT DESCRIPTION: I designed and developed this application with 2 members. This application has the following operations:\n" +
                    "-\tUser and team registeration, User can join another team\n" +
                    "-\tTask and comment registeration, \n" +
                    "-\tOverdue tasks to highlighted to users, …\n" +
                    "TECHNOLOGIES USED (in order): \n" +
                    "JAVA, Spring, servlets, JSON, AJAX, JQuery, HTML, CSS, IntelliJ, Maven, Postgre\n\n" +
                    "3. PROJECT TITLE:Library System\n" +
                    "SCHOOL: MUM\n" +
                    "PROJECT YEAR:2018\n" +
                    "PROJECT DESCRIPTION: Worked with three members to design and develop a small library system. It contains librarian, author, administrator and book registeration and book checkout… \n" +
                    "TECHNOLOGIES USED (in order):\n" +
                    "Java, CSS, Gitlab, Singleton, JavaFx UI",
            addList2,
            eduList2,
            workList2,
            prList2)

        personList.add(p2)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_home -> {
                finish()
                return true
            }
            R.id.action_add -> {
                addListItem()
                return true
            }
            R.id.action_about -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("About us")
                builder.setMessage("Developed by Tuugii & Puje - MUM 2019 Fall")
                builder.setIcon(R.drawable.alerticon)

                builder.setPositiveButton("Close"){dialogInterface, which ->
                    Toast.makeText(applicationContext,"It's a positive action click by which id : $which",
                        Toast.LENGTH_SHORT).show()
                    dialogInterface.dismiss() // dismiss the dialog
                    //finish() // to destroy the activity
                }

                val dialog: AlertDialog = builder.create()
                dialog.show()
                return true
            }
            R.id.action_exit -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Exit")
                builder.setMessage("Do you want to Exit")
                builder.setIcon(R.drawable.alerticon)

                builder.setPositiveButton("Yes"){dialogInterface, which ->
                    dialogInterface.dismiss()
                    System.exit(0)
                }
                // 4. Performing Cancel action on clicking Cancel button
                builder.setNegativeButton("Cancel"){dialogInterface, which ->
                    dialogInterface.dismiss()
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()
                return true
            }
            R.id.action_reload -> {
                reload()
                return true
            }
            R.id.action_load -> {
                loadDataFromStorage()
                return true
            }
            R.id.action_save -> {
                if (personList.size > 0)
                {
                    val persons = Persons()
                    persons.personList = personList
                    // Conversion Employees list object to JSON using Gson
                    val gson = Gson()
                    val response = gson.toJson(persons)
                    // Writing the converted data into File using FileWriter in Your device external storage
                    val path = (Environment.getExternalStorageDirectory().absolutePath
                            + "/persons_gson.json")
                    try
                    {
                        val writer = FileWriter(path)
                        writer.write(response)
                        writer.flush()
                        writer.close()
                        Toast.makeText(applicationContext, "Write successfully on file", Toast.LENGTH_LONG).show()
                    }
                    catch (e1: IOException) {
                        e1.printStackTrace()
                    }
                }
                else
                    Toast.makeText(applicationContext, "Can't Write Empty List", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_delete -> {
                personList.removeAt(personList.size - 1)
                adapter?.notifyDataSetChanged()
                return true
            }
            else -> super.onOptionsItemSelected(item)

        }

        return false
    }

    fun reload(){
        personList.clear()
        init()
        adapter?.notifyDataSetChanged()
    }

    fun loadDataFromStorage(){
        val path = (Environment.getExternalStorageDirectory()
            .absolutePath + "/persons_gson.json")
        try
        {
            val reader = FileReader(path)
            val gson = Gson()
            val persons = gson.fromJson(reader, Persons::class.java)
            Toast.makeText(applicationContext, persons.toString(), Toast.LENGTH_LONG).show()
            personList.clear()
            //adapter?.notifyDataSetChanged()

            if (persons.personList.size > 0){
                for (e in persons.personList){
                    personList.add(e)
                    Toast.makeText(applicationContext, e.toString(), Toast.LENGTH_LONG).show()
                }
                adapter?.notifyDataSetChanged()
            }
            else
                Toast.makeText(applicationContext, "No data", Toast.LENGTH_LONG).show()
        }
        catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }

}
