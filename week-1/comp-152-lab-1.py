def get_min_int():
    # ask user to enter number
    print("This program finds the smallest of the integers you enter.")
    smallest_int = None
    user_input = ""
    # program ends when Q or q is entered
    while user_input != "Q" or user_input != "q":
        user_input = input("Enter an integer (Q or q to quit)").strip()
        if user_input != "Q" or user_input != "q":
            # what if the user presses a char ! Q or q eg. a or b
            if type(user_input) == int:
                # at the very begining of the execution if smallest_int is
                if type(smallest_int) == None:
                    smallest_int = int(user_input)
                if smallest_int > user_input:
                    smallest_int = user_input

    print("The smallest number you entered is {}", smallest_int)


get_min_int()
