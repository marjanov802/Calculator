4/12/2023 

Release 3 tested - Bug found 
When infix was True the correct answer was given every time however when the infix was False the answer always came back as 0.
This was a coding error in the StandardCalc class where during the development of the class return 0 (which was initally used to pass the simple tdd tests) was never removed. 
To fix the code return 0 was replaced by a call of the evaluate method in the reverse calculator method to work out the answer to the expression. 
The answer is returned correctly now and the tests in the release testing all pass.
