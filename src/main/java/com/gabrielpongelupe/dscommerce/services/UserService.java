package com.gabrielpongelupe.dscommerce.services;

import com.gabrielpongelupe.dscommerce.dto.CreateUserDTO;
import com.gabrielpongelupe.dscommerce.dto.UserDTO;
import com.gabrielpongelupe.dscommerce.entities.User;
import com.gabrielpongelupe.dscommerce.exceptions.ResourceNotFoundException;
import com.gabrielpongelupe.dscommerce.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(user -> modelMapper.map(user, UserDTO.class));
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return modelMapper.map(user, UserDTO.class);
    }

    @Transactional
    public UserDTO insert(CreateUserDTO createUserDTO) {
        User user = modelMapper.map(createUserDTO, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Transactional
    public UserDTO update(Long id, CreateUserDTO createUserDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        user.setBirthday(createUserDTO.getBirthday());
        user.setEmail(createUserDTO.getEmail());
        user.setName(createUserDTO.getName());
        user.setPassword(createUserDTO.getPassword());
        user.setPhone(createUserDTO.getPhone());

        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }
        userRepository.deleteById(id);
    }
}
