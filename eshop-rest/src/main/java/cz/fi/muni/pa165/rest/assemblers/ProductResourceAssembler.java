package cz.fi.muni.pa165.rest.assemblers;

import cz.fi.muni.pa165.rest.controllers.ProductsControllerHateoas;
import dto.TireDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * This class shows a resource assembler for a HATEOAS REST Service we are
 * mapping the DTO to a resource that can provide links to the different parts
 * of the API See
 * http://docs.spring.io/spring-hateoas/docs/current/reference/html/
 *
 * @author brossi
 * adjusted Jakub Palenik
 */
@Component
public class ProductResourceAssembler implements ResourceAssembler<TireDTO, Resource<TireDTO>> {

    @Override
    public Resource<TireDTO> toResource(TireDTO productDTO) {
        long id = productDTO.getId();
        Resource<TireDTO> productResource = new Resource<TireDTO>(productDTO);

        try {
            productResource.add(linkTo(ProductsControllerHateoas.class).slash(productDTO.getId()).withSelfRel());
            productResource.add(linkTo(ProductsControllerHateoas.class).slash(productDTO.getId()).withRel("DELETE"));

        } catch (Exception ex) {
            Logger.getLogger(ProductResourceAssembler.class.getName()).log(Level.SEVERE, "could not link resource from ProductsControllerHateoas", ex);
        }

        return productResource;
    }
}
