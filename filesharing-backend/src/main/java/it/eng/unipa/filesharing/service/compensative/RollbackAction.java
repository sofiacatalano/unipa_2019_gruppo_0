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
//public class RollbackAction {
//	
//	
//	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//
//	
//	@Autowired
//	protected ResourceRepository resourceRepository;
//
//	
//	public static class ResourceApplicationEvent extends ApplicationEvent{
//
//		private static final long serialVersionUID = 1L;
//
//		public ResourceApplicationEvent(Resource...resources) {
//			super(resources);
//		}
//
//	}
//	
//	@TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
//	public void handleAfterRollback(ResourceApplicationEvent event) throws IOException {
//		/*
//		 *  gestione rollback applicativo
//		 */
//		LOGGER.warn("executing rollback on !"+this.getClass().getName());
//		
//		Resource[] resources = (Resource[])event.getSource();
//		for(Resource resource : resources) {
//			boolean deleted = resourceRepository.delete(resource,false);
//			LOGGER.warn("Delete File --> {} esito:{}", resource.getName(), deleted);
//		}
//
//	}
//}