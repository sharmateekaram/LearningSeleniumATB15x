package org.thetestingacademy.Selenium003_Xpath;

import org.testng.annotations.Test;

public class SeleniumXpath3_Functions {

    @Test
    public void seleniumXpath_Function(){

/*
        Text Functions
        1) Select element based on exact text.

// button[text()='Login']

        2) contains()
        Used for partial match.
//div[contains(text(),'Welcome')]

        Also for attributes:

//input[contains(@id,'user')]

        3. starts-with()
//input[starts-with(@id,'user_')]

        4. normalize-space()
//button[normalize-space()='Login']

        2️⃣ Attribute Functions
        5. @attribute
//input[@type='text']

        6. not()
//input[not(@disabled)]

✅ 3️⃣ Logical Operators
        7. and
//input[@type='text' and @name='username']

        8. or
//input[@type='text' or @type='email']

✅ 4️⃣ Position Functions
        9. position()
//input[position()=1]

        10. last()
//tr[last()]

        Second last:

//tr[last()-1]

✅ 5️⃣ String Functions

        11. string-length()
//input[string-length(@value) > 5]

        12. substring()
//input[substring(@id,1,4)='user']

        13. substring-before()
        substring-before('user_123','_')

        14. substring-after()
        substring-after('user_123','_')

✅ 6️⃣ Number Functions

        16. count()
        count(//input)

                17. sum()
                sum(//price)

                */

    }
}
