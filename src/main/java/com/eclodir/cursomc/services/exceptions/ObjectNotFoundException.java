/* Classe: ObjectNotFound
 * Responsabilidade: Retorna uma excessão (error) ao quando chamada devido não ser encontrado determinado objeto
 * 1 - Esta classe deve extender a classe RuntimeExeptions
 * 2 - Criar o construtores utilizando atributos da classe mãe
 */

package com.eclodir.cursomc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException (String msg) {
		super(msg); //Reaproveitando a infraestutura fornecida pela classe mãe
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
