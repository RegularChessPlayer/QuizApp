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
        Double percentCorect = ((double)correctAnsers / (double) questions.size()) * 100;
        return percentCorect;
    }

    public void resetGame(){
        this.responses.clear();
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

        Question q1 = new Question(1, "É um país da Europa.", null, list);
        this.questions.add(q1);


        Question q2 = new Question(2, " No Passado invadiu o Brasil ?", null, list);
        this.questions.add(q2);


        Question q3 = new Question(3, "Tirou o Brasil da Copa.", null, list);
        this.questions.add(q3);

        Question q4 = new Question(4, "É a terra das flores.", null, list);
        this.questions.add(q4);


        Question q5 = new Question(5, "Amsterdã é capital de qual país ?", null, list);
        this.questions.add(q5);

    }

}
