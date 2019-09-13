//package it.eng.unipa.filesharing.service.compensative;
//
//import java.io.IOException;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.event.TransactionPhase;
//import org.springframework.transaction.event.TransactionalEventListener;
//
//import it.eng.unipa.filesharing.model.resource.Resource;
//import it.eng.unipa.filesharing.model.resource.ResourceRepository;
//
//@Scope("singleton")
//@Component
//public class CommitAction {
//	
//	
//	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//
//	
//	@Autowired
//	protected ResourceRepository resourceRepository;
//
//	
//	public static class DeleteResourceApplicationEvent extends ApplicationEvent{
//
//		private static final long serialVersionUID = 1L;
//
//		public DeleteResourceApplicationEvent(Resource...resources) {
//			super(resources);
//		}
//
//	}
//	
//	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
//	public void handleAfterCommit(DeleteResourceApplicationEvent event) throws IOException {
//		/*
//		 *  gestione rollback applicativo
//		 */
//		LOGGER.warn("executing after commit on !"+this.getClass().getName());
//		
//		Resource[] resources = (Resource[])event.getSource();
//		for(Resource resource : resources) {
//			boolean deleted = resourceRepository.delete(resource,false);
//			LOGGER.info("Delete File  --> {} esito:{}", resource.getName(), deleted);
//		}
//
//	}
//}