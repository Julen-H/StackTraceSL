## Enterprise management systems
### The importance of ERP personalization

The creation of new features and modules is important to personalize an ERP for one specific enterprise. In a lot of professional settings companies will need for the developer to be able to improve the 
capabilities of their software by adding new features.
In our case, we have created a new Odoo module for this exact reason. We needed a module for a niche feature like a game tournament. To achieve this we used Odoo’s built in tools to create new modules 
like scaffold. 

### Instalation and server setup

First of all we created a new server using the latest release for Debian, Debian 12. We chose Debian for it's simplicity, compatibility with different software but mainly because of it's rock solid stability.
Debian is widely regarded as a fantastic server option for this very reason and we have to say that we had 0 problems with our Debian 12 VM. 
The first part of server setup was seting up our user, IP config, necesary packages for our server (wget, gpp, python3...) and ssh access to the server. Once that wa done it was time to install Odoo, 
the ERP where we are going to base our development on.

### Odoo installation

Odoo requires postgresql installed in our server to function, so we quickly installed the official release version for postgresql in our server. This was painless and quick. Once that was done,
we followed the instruction in [Odoo's installation page](https://www.odoo.com/documentation/16.0/administration/install.html) and quickly setup our Odoo server. Once again, we didn't have any 
problems with this due to our previous experience with this same ERP. We set up the Odoo users and other stuff and we were quickly in a position to start with the modules development.

### Odoo module development

The main thing with this module was to think of a database table design that made sense for our purpose, Once we had the design we set off to create the module.
Using our existing Odoo server in a Debian VM, we executed the command odoo scaffold <module name> <module location> 
and created the module tournament. Once the module was created, we modified it’s fields and code( modifying directly on the server via ssh) to end up with a real module that then we installed in our 
Odoo installation. We can make sure the module is created correctly by checking our postgres database. Once the table is there, we can start adding data using our API, or directly by adding data via Odoo, 
in the modules window.

### Final words
In the end, our Odoo installation and module design were rock solid and didn't give us any kind of problems at any point in the challenge. We realize that we didn't put much into modifying the 
aspect of the module inside Odoo, which is a basic list and form to view, delete and add records to our database, but we learned quite a lot about how different programs interact with this database and
the best prectices for postgresql( which Odoo is based on). For the future, we would have liked to add more capabilities for the module in Odoo's website itself. 
