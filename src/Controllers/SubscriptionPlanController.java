package Controllers;
import Models.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionPlanController {
    private List<SubscriptionPlan> subscriptionPlanList = new ArrayList<>();

    public List<SubscriptionPlan> index(){return subscriptionPlanList;}

    public void store(SubscriptionPlan subscription_plan){
        for (SubscriptionPlan data : subscriptionPlanList){
            if(data.getName().equalsIgnoreCase(subscription_plan.getName())){
                throw new IllegalArgumentException("O Plano de inscrição com o nome '" + subscription_plan.getName() + "' já existe na base !!!.");
            }
        }
        subscriptionPlanList.add(subscription_plan);
    }

    public SubscriptionPlan show(String name){
        for (SubscriptionPlan subscription_plan : subscriptionPlanList){
            if(subscription_plan.getName().equalsIgnoreCase(name)){return subscription_plan;}
            //problema quando tem espaço
        }
        throw new IllegalArgumentException("O Plano de inscrição com o nome '" + name + "' não foi encontrado.");
    }

    public boolean update(String name, String newName){
        SubscriptionPlan subscription_plan = show(name);
        subscription_plan.setName(name);
        return true;
    }

    public boolean delete(String name){
        SubscriptionPlan subscription_plan = show(name);
        subscriptionPlanList.remove(subscription_plan);
        return true;
    }

}
