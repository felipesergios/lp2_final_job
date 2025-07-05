package Controllers;
import Models.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionPlanController {
    private List<SubscriptionPlan> subscriptionPlanList = new ArrayList<>();

    public List<SubscriptionPlan> index(){return subscriptionPlanList;}

    public void store(SubscriptionPlan subscription_plan){subscriptionPlanList.add(subscription_plan);}

    public SubscriptionPlan show(String name){
        for (SubscriptionPlan subscription_plan : subscriptionPlanList){
            if(subscription_plan.getName().equalsIgnoreCase(name)){return subscription_plan;}
        }
        return null;
    }

    public boolean update(String name, String newName){
        SubscriptionPlan subscription_plan = show(name);
        if(subscription_plan != null){subscription_plan.setName(newName);return true;}
        return false;
    }

    public boolean delete(String name){
        SubscriptionPlan subscription_plan = show(name);
        if(subscription_plan != null){subscriptionPlanList.remove(subscription_plan);return true;}
        return false;
    }

}
