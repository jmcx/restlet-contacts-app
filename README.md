restlet-contacts-app
====================

A simple contact list app built with Restlet.

how to 
====================

This application depends on the restlet framework's org.restlet.jar. You can download the Java SE version directly from http://www.restlet.org. 

Instructions for running the project with eclipse:

Clone the project from github into a suitable location. The project in now in a folder called restlet-contacts-app/.

Start a new project in eclipse and name it using the name restlet-contacts-app/.

Uncheck the "use default location" box and find the directory where your project is unless your project is already in the workspace - then you must not uncheck the "use default location" box.

Click 'finish'.

Make sure org.restlet.jar is in the project's classpath. 

Run the contacts.app.Main.java main program. This will start a simple http server and you should be able to access the application with a browser at the URL "http://localhost:8182/contactsapp/static/index.html". 

To run the tests (TestMain.java), you must include the required JUnit jar.

That should be it! 