package by.tms.hibernate.service;

import by.tms.hibernate.dao.OperationDao;
import by.tms.hibernate.entity.Operation;
import by.tms.hibernate.sessionfactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import static by.tms.hibernate.constants.operation.ConstantsOperation.*;

public class OperationService {

    private final OperationDao operationDao = new OperationDao();

    public OperationService() {  }

    public void save(Operation operation) {
        operationDao.saveFromDB(operation);
    }

    public void update(Operation operation) {
        operationDao.updateFromDB(operation);
    }

    public void remove(Operation operation) {
        operationDao.deleteFromDB(operation);
    }

    public Operation findById(int id) {
        return operationDao.findByIdFromDB(id);
    }

    public List<Operation> findAll() {
        return operationDao.findAllFromDB();
    }

    public void calculator(Operation operation) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        switch (operation.getOperand()) {
            case PLUS:
                operation.setResult(operation.getNum1() + operation.getNum2());
                break;
            case MINUS:
                operation.setResult(operation.getNum1() - operation.getNum2());
                break;
            case MULTIPLY:
                operation.setResult(operation.getNum1() * operation.getNum2());
                break;
            case DIVIDE:
                operation.setResult(operation.getNum1() / operation.getNum2());
                break;
            default:
                operation.setOperand(INCORRECT_OPERAND);
                break;
        }
        session.update(operation);
        transaction.commit();
        session.close();
    }

}
