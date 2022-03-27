
#My Machine Learning project:
This is a project I created for the second semester of OOP. It uses
Naive Bayes to read a dataset and calculates the probability of
someone becoming an entrepreneur or a comic book character being a hero.

##Core Functionality:
The core functionality of this program is that it can read a dataset and perform Naive Bayes on it
to determine the probability of someone becoming an entrepreneur.

##Advanced Functionality:
The advanced functionality of this program is that the UI and data reading
are performed dynamically based on the inputted data. By using a categorical
CSV file, the program is able to dynamically read info about the dataset
and perform Naive Bayes with no modification to the code.

##What would I add?:
If I had more time for this project I would consider finding an algorithm similar
to Naive Bayes and see if i could increase the accuracy or experiment with adding
functionality for numerical data rather than categorical data.

##Link to video:
ADD LINK TO VIDEO.


##Classes:
###MachineLearning
####FileReader:
Used to read in the contents of a file using the Java file object.

####CSVReader:
An implementation of FileReader that is built to read in a CSV.

####DataAnalyser:
A class which splits the dataset into a form which is easier to read.

####NaiveBayes:
Performs the Naive Bayes algorithm on the dataset passed to the CSV Reader.

####Main:
Runs the main code to demonstrate how it works.

###MachineLearningGUI

####CustomComponents:
A class which creates customised styled components for the GUI.

####Model
A class which stores all the data used by the GUI.

####View
A class which stores all the UI elements of the GUI.

####Controller
A class which interacts with the model and view to display information.

####Main
A class which initialises the main GUI.
