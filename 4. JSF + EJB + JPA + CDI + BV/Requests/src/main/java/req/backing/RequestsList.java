/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package req.backing;

import java.time.LocalDate;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.validation.constraints.Size;
import req.entities.Request;
import req.facade.RequestFacadeLocal;

/**
 *
 * @author Bartek
 */
@Named(value = "requestsList")
@RequestScoped
public class RequestsList {

    @Inject
    private RequestFacadeLocal requestFacade;
    
    @Size(min = 3, max = 60, message="{request.size}") 
    private String newRequest;
    private HtmlDataTable requestsDataTable;
    
    private Request request;

    
    public String addRequest()
    {
        Request request = new Request();
        request.setRequestText(getNewRequest());
        request.setRequestDate(LocalDate.now());
        requestFacade.create(request);
        setNewRequest("");
        return null;
    } 
    
    public String deleteRequest() {
        Request req =
        (Request) getRequestsDataTable().getRowData();
        requestFacade.remove(req);
        return null;
        }

    /**
     * Get the value of request
     *
     * @return the value of request
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Set the value of request
     *
     * @param request new value of request
     */
    public void setRequest(Request request) {
        this.request = request;
    }


    /**
     * Get the value of requestsDataTable
     *
     * @return the value of requestsDataTable
     */
    public HtmlDataTable getRequestsDataTable() {
        return requestsDataTable;
    }

    /**
     * Set the value of requestsDataTable
     *
     * @param requestsDataTable new value of requestsDataTable
     */
    public void setRequestsDataTable(HtmlDataTable requestsDataTable) {
        this.requestsDataTable = requestsDataTable;
    }

    /**
     * Get the value of newRequest
     *
     * @return the value of newRequest
     */
    public String getNewRequest() {
        return newRequest;
    }

    /**
     * Set the value of newRequest
     *
     * @param newRequest new value of newRequest
     */
    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }

    /**
     * Creates a new instance of RequestsList
     */
    public RequestsList() {
        request = new Request();
    }
    
    public List<Request> getAllRequests() {
        return requestFacade.findAll();
    }

}
