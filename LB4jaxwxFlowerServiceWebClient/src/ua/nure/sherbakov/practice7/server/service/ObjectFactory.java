
package ua.nure.sherbakov.practice7.server.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.nure.sherbakov.practice7.server.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetFlower_QNAME = new QName("http://practice7.sherbakov.nure.ua/server/service", "getFlower");
    private final static QName _DeleteFlower_QNAME = new QName("http://practice7.sherbakov.nure.ua/server/service", "deleteFlower");
    private final static QName _FindByNameResponse_QNAME = new QName("http://practice7.sherbakov.nure.ua/server/service", "findByNameResponse");
    private final static QName _FindByOrigin_QNAME = new QName("http://practice7.sherbakov.nure.ua/server/service", "findByOrigin");
    private final static QName _DAOException_QNAME = new QName("http://practice7.sherbakov.nure.ua/server/service", "DAOException");
    private final static QName _AddFlower_QNAME = new QName("http://practice7.sherbakov.nure.ua/server/service", "addFlower");
    private final static QName _AddFlowerResponse_QNAME = new QName("http://practice7.sherbakov.nure.ua/server/service", "addFlowerResponse");
    private final static QName _ListFlowers_QNAME = new QName("http://practice7.sherbakov.nure.ua/server/service", "listFlowers");
    private final static QName _FindByOriginResponse_QNAME = new QName("http://practice7.sherbakov.nure.ua/server/service", "findByOriginResponse");
    private final static QName _ListFlowersResponse_QNAME = new QName("http://practice7.sherbakov.nure.ua/server/service", "listFlowersResponse");
    private final static QName _FindByName_QNAME = new QName("http://practice7.sherbakov.nure.ua/server/service", "findByName");
    private final static QName _DeleteFlowerResponse_QNAME = new QName("http://practice7.sherbakov.nure.ua/server/service", "deleteFlowerResponse");
    private final static QName _GetFlowerResponse_QNAME = new QName("http://practice7.sherbakov.nure.ua/server/service", "getFlowerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.nure.sherbakov.practice7.server.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFlowerResponse }
     * 
     */
    public GetFlowerResponse createGetFlowerResponse() {
        return new GetFlowerResponse();
    }

    /**
     * Create an instance of {@link DeleteFlowerResponse }
     * 
     */
    public DeleteFlowerResponse createDeleteFlowerResponse() {
        return new DeleteFlowerResponse();
    }

    /**
     * Create an instance of {@link FindByName }
     * 
     */
    public FindByName createFindByName() {
        return new FindByName();
    }

    /**
     * Create an instance of {@link ListFlowersResponse }
     * 
     */
    public ListFlowersResponse createListFlowersResponse() {
        return new ListFlowersResponse();
    }

    /**
     * Create an instance of {@link FindByOriginResponse }
     * 
     */
    public FindByOriginResponse createFindByOriginResponse() {
        return new FindByOriginResponse();
    }

    /**
     * Create an instance of {@link AddFlowerResponse }
     * 
     */
    public AddFlowerResponse createAddFlowerResponse() {
        return new AddFlowerResponse();
    }

    /**
     * Create an instance of {@link ListFlowers }
     * 
     */
    public ListFlowers createListFlowers() {
        return new ListFlowers();
    }

    /**
     * Create an instance of {@link DAOException }
     * 
     */
    public DAOException createDAOException() {
        return new DAOException();
    }

    /**
     * Create an instance of {@link AddFlower }
     * 
     */
    public AddFlower createAddFlower() {
        return new AddFlower();
    }

    /**
     * Create an instance of {@link FindByOrigin }
     * 
     */
    public FindByOrigin createFindByOrigin() {
        return new FindByOrigin();
    }

    /**
     * Create an instance of {@link FindByNameResponse }
     * 
     */
    public FindByNameResponse createFindByNameResponse() {
        return new FindByNameResponse();
    }

    /**
     * Create an instance of {@link DeleteFlower }
     * 
     */
    public DeleteFlower createDeleteFlower() {
        return new DeleteFlower();
    }

    /**
     * Create an instance of {@link GetFlower }
     * 
     */
    public GetFlower createGetFlower() {
        return new GetFlower();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlower }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/server/service", name = "getFlower")
    public JAXBElement<GetFlower> createGetFlower(GetFlower value) {
        return new JAXBElement<GetFlower>(_GetFlower_QNAME, GetFlower.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFlower }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/server/service", name = "deleteFlower")
    public JAXBElement<DeleteFlower> createDeleteFlower(DeleteFlower value) {
        return new JAXBElement<DeleteFlower>(_DeleteFlower_QNAME, DeleteFlower.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/server/service", name = "findByNameResponse")
    public JAXBElement<FindByNameResponse> createFindByNameResponse(FindByNameResponse value) {
        return new JAXBElement<FindByNameResponse>(_FindByNameResponse_QNAME, FindByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByOrigin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/server/service", name = "findByOrigin")
    public JAXBElement<FindByOrigin> createFindByOrigin(FindByOrigin value) {
        return new JAXBElement<FindByOrigin>(_FindByOrigin_QNAME, FindByOrigin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DAOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/server/service", name = "DAOException")
    public JAXBElement<DAOException> createDAOException(DAOException value) {
        return new JAXBElement<DAOException>(_DAOException_QNAME, DAOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFlower }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/server/service", name = "addFlower")
    public JAXBElement<AddFlower> createAddFlower(AddFlower value) {
        return new JAXBElement<AddFlower>(_AddFlower_QNAME, AddFlower.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFlowerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/server/service", name = "addFlowerResponse")
    public JAXBElement<AddFlowerResponse> createAddFlowerResponse(AddFlowerResponse value) {
        return new JAXBElement<AddFlowerResponse>(_AddFlowerResponse_QNAME, AddFlowerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListFlowers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/server/service", name = "listFlowers")
    public JAXBElement<ListFlowers> createListFlowers(ListFlowers value) {
        return new JAXBElement<ListFlowers>(_ListFlowers_QNAME, ListFlowers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByOriginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/server/service", name = "findByOriginResponse")
    public JAXBElement<FindByOriginResponse> createFindByOriginResponse(FindByOriginResponse value) {
        return new JAXBElement<FindByOriginResponse>(_FindByOriginResponse_QNAME, FindByOriginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListFlowersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/server/service", name = "listFlowersResponse")
    public JAXBElement<ListFlowersResponse> createListFlowersResponse(ListFlowersResponse value) {
        return new JAXBElement<ListFlowersResponse>(_ListFlowersResponse_QNAME, ListFlowersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/server/service", name = "findByName")
    public JAXBElement<FindByName> createFindByName(FindByName value) {
        return new JAXBElement<FindByName>(_FindByName_QNAME, FindByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFlowerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/server/service", name = "deleteFlowerResponse")
    public JAXBElement<DeleteFlowerResponse> createDeleteFlowerResponse(DeleteFlowerResponse value) {
        return new JAXBElement<DeleteFlowerResponse>(_DeleteFlowerResponse_QNAME, DeleteFlowerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlowerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://practice7.sherbakov.nure.ua/server/service", name = "getFlowerResponse")
    public JAXBElement<GetFlowerResponse> createGetFlowerResponse(GetFlowerResponse value) {
        return new JAXBElement<GetFlowerResponse>(_GetFlowerResponse_QNAME, GetFlowerResponse.class, null, value);
    }

}
