package com.example.thiago.quizproject.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class QuizGameController implements Serializable {

    private ArrayList<Question> questions = new ArrayList<Question>();

    private HashMap<Integer, QuestionItem>responses = new HashMap<Integer, QuestionItem>();//maybe

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    int selectedQuestion = 0;

    public Question backQuestion(){
        int previousPosition = selectedQuestion - 1;
        if((previousPosition) >= 0){
            selectedQuestion = previousPosition;
            return questions.get(previousPosition);
        }else{
            selectedQuestion = (questions.size() - 1);
            return questions.get((questions.size() - 1));
        }
    }

   public Question nexQuestion(){
        int nexPosition = selectedQuestion + 1;
        if((nexPosition) < questions.size()){
            selectedQuestion = nexPosition;
            return questions.get(nexPosition);
        }else{
            selectedQuestion = 0;
            return questions.get(0);
        }
    }

    public void markIteInQUestion(int positionItem){ //Enum more Reusable
        this.persistResponse(new Integer(this.selectedQuestion), questions.get(selectedQuestion)
                .getItems().get(positionItem));
    }

     private void persistResponse(Integer idQuestion, QuestionItem item){
        this.responses.put(idQuestion, item);
    }

    public Double returnPercentCorrectAnswers(){
        int correctAnsers = 0;
        for (QuestionItem item  : responses.values()){
            if(item.isCorrect()){
                correctAnsers += 1;
            }
        }
        Double percentCorect = new Double(correctAnsers / questions.size());
        return percentCorect;
    }


    public void setupDumyQuestions(){ //read from out source
        //load question
        ArrayList<QuestionItem> list = new ArrayList<>();
        QuestionItem item1 = new QuestionItem(1,"Alemanha", false);
        list.add(item1);
        QuestionItem item2 = new QuestionItem(2,"Franca", false);
        list.add(item2);
        QuestionItem item3 = new QuestionItem(3,"Grecia", false);
        list.add(item3);
        QuestionItem item4 = new QuestionItem(4, "Holanda", true);
        list.add(item4);
        Question q1 = new Question(1, "É um país da Europa. No Passado invadiu o Brasil, Tirou o Brasil da Copa. É a terra das flores\"", null, list);
        this.questions.add(q1);


        item4.setCorrect(false);
        item2.setDescriptionItem("Portugal");
        item2.setCorrect(true);

        Question q2 = new Question(2, " Quem colonizou o Brasil ?.", null, list);
        this.questions.add(q2);

        item2.setCorrect(false);
        item3.setDescriptionItem("Australia");
        item3.setCorrect(true);

        Question q3 = new Question(3, "Kangorros são nativos de qual país ?.", null, list);
        this.questions.add(q3);

        Question q4 = new Question(4, "Peter Singer famoso filósofo de qual país ?.", null, list);
        this.questions.add(q4);

        item3.setCorrect(false);
        item1.setCorrect(true);
        Question q5 = new Question(5, "Berlim é capital de qual país ?", null, list);
        this.questions.add(q5);

    }

}
