**How to:**

Build the project without tests: *maven -s settings.xml install -Dmaven.test.skip*

Run all tests: *maven -s settings.xml verify*

Run tests from specific group: *maven -s settings.xml verify -Dgroups=validInput*