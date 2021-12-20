package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import models.ReimbDTO;
import models.Reimbursement;
import services.ReimbursementService;

import java.util.List;

public class ReimbursementController {

    static ReimbursementService reimbursementService = new ReimbursementService();

    public void getAllReimbs(Context context) throws JsonProcessingException {
            context.contentType("application/json");
            context.header("Access-Control-Allow-Origin", "*");


        Integer userId = Integer.parseInt(context.pathParam("userId"));

        List<Reimbursement> reimbursementList = reimbursementService.getAllReimb(userId);
        if (reimbursementList == null) {
            context.status(404);
            context.result("error not found");
        }else {

            String jsonString = new ObjectMapper().writeValueAsString(reimbursementList);

            context.result(jsonString);
        }


    }

    public void getOneReimb(Context context) throws JsonProcessingException {
        context.contentType("application/json");
//        Integer userId = Integer.parseInt(context.pathParam("id"));
        Integer reimbId = Integer.parseInt(context.pathParam("reimbId"));

        Reimbursement reimbursement = reimbursementService.getOneReimb(reimbId);

        String jsonString = new ObjectMapper().writeValueAsString(reimbursement);
        context.result(jsonString);


    }

    public void createReimb(Context context) throws JsonProcessingException{
        context.contentType("application/json");
        Integer userId = Integer.parseInt(context.pathParam("userId"));
        ReimbDTO reimbursement = context.bodyAsClass(ReimbDTO.class);

        if (userId == null) {
            context.status(404);
        } else {

            reimbursementService.createReimb(reimbursement);
            String jsonString = new ObjectMapper().writeValueAsString(reimbursement);
            context.result(jsonString);
        }

    }


    public void updateOneReimb(Context context) throws JsonProcessingException {
        context.contentType("application/json");
        Integer userId = Integer.parseInt(context.pathParam("userId"));
        Reimbursement reimbursement = context.bodyAsClass(Reimbursement.class);

        System.out.println(reimbursement + "     update1");
        System.out.println(userId + "     update2");


        if (reimbursementService.updateReimb(reimbursement, userId) == false ){
            context.status(404);
        } else {
            reimbursementService.updateReimb(reimbursement, userId);
            context.json(reimbursement);
        }



    }

    public void getAllReimbsAdmin(Context context) throws JsonProcessingException {
        context.contentType("application/json");



        List<Reimbursement> reimbursementList = reimbursementService.getAllReimb();
        if (reimbursementList == null) {
            context.status(404);
            context.result("error not found");
        }else {

            String jsonString = new ObjectMapper().writeValueAsString(reimbursementList);

            context.result(jsonString);
        }


    }

}
