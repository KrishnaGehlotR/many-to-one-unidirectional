package com.jspiders.manyToOne.tester;

import java.util.List;

import com.jspiders.manyToOne.dao.TreeDAO;
import com.jspiders.manyToOne.dto.LeafDTO;
import com.jspiders.manyToOne.dto.TreeDTO;

public class AppTester {

	public static void main(String[] args) {
		/*TreeDTO treeDTO = new TreeDTO();
		LeafDTO leafDTO = new LeafDTO();
		
		treeDTO.setName("Neem");
		treeDTO.setHeight(120.5);
		treeDTO.setYears(50);
		
		leafDTO.setColour("Green");
		leafDTO.setShape("Rectangle");
		leafDTO.setWeight(2.9);
		
		LeafDTO leafDTO2 = new LeafDTO();
		leafDTO2.setColour("dark Green");
		leafDTO2.setShape("Circle");
		leafDTO2.setWeight(3.5);
		
		LeafDTO leafDTO3 = new LeafDTO();
		leafDTO3.setColour("Light Green");
		leafDTO3.setShape("Traingle");
		leafDTO3.setWeight(1.5);
		
		List<LeafDTO> listOfLeaf = new ArrayList<LeafDTO>();
		listOfLeaf.add(leafDTO);
		listOfLeaf.add(leafDTO2);
		listOfLeaf.add(leafDTO3);
		
		leafDTO.setTreeDTO(treeDTO);
		leafDTO2.setTreeDTO(treeDTO);
		leafDTO3.setTreeDTO(treeDTO);
		treeDTO.setLeafDTOList(listOfLeaf);
		
		TreeDAO treeDAO = new TreeDAO();
		treeDAO.saveTree(treeDTO);*/
		
		/*LeafDAO  leafDAO = new LeafDAO();
		LeafDTO leafDTO = leafDAO.getLeafById(1);
		if (leafDTO != null) {
			TreeDTO treeDTO = leafDTO.getTreeDTO();
			System.out.println("Leaf Colour: " + leafDTO.getColour());
			System.out.println("Tree name: " + treeDTO.getName());
		}*/
		
		TreeDAO treeDAO = new TreeDAO();
		TreeDTO treeDTO = treeDAO.getTreeById(2);
		if (treeDTO != null) {
			System.out.println("------------------------------------");
			System.out.println(treeDTO.getName());
			List<LeafDTO> listOfLeafDTO = treeDTO.getLeafDTOList();
			for (LeafDTO leafDTO : listOfLeafDTO) {
				System.out.println("------------------------------------");
				System.out.println("Leaf Colour: " + leafDTO.getColour());
			}
			
		}
		
	}

}
