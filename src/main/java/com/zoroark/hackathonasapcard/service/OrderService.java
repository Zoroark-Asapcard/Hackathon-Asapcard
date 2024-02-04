import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoroark.hackathonasapcard.model.Order;
import com.zoroark.hackathonasapcard.repository.OrderRepository;

@Service
	public class OrderService {
	

	@Autowired
    private OrderRepository orderRepository;

    // Outros métodos do serviço...

    public Order saveOrder(Order order) {
        // Use o OrderRepository para salvar a ordem no banco de dados
        return orderRepository.saveAll(order);
    }

    public Order findOrderById(Long orderId) {
        // Use o OrderRepository para buscar a ordem no banco de dados por ID
        return orderRepository.findById(orderId).orElse(null);
    }
	}